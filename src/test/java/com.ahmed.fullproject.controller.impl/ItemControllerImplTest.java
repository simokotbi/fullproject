package com.ahmed.fullproject.controller.impl;

import com.ahmed.fullproject.controller.impl.CustomUtils;
import com.ahmed.fullproject.controller.impl.ItemControllerImpl;
import com.ahmed.fullproject.dto.ItemDTO;
import com.ahmed.fullproject.entity.Item;
import com.ahmed.fullproject.mapper.ItemMapper;
import com.ahmed.fullproject.mapper.ReferenceMapper;
import com.ahmed.fullproject.service.ItemService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ItemControllerImplTest {
    //TODO: create the data Test generator class ItemBuilder
    private static final String ENDPOINT_URL = "/items";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private ItemControllerImpl itemController;
    @MockBean
    private ItemService itemService;
    @MockBean
    private ItemMapper itemMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.itemController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(itemMapper.asDTOList(ArgumentMatchers.any())).thenReturn(ItemBuilder.getListDTO());

        Mockito.when(itemService.findAll()).thenReturn(ItemBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(itemMapper.asDTO(ArgumentMatchers.any())).thenReturn(ItemBuilder.getDTO());

        Mockito.when(itemService.findById(ArgumentMatchers.anyInteger())).thenReturn(java.util.Optional.of(ItemBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(itemService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(itemService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(itemMapper.asEntity(ArgumentMatchers.any())).thenReturn(ItemBuilder.getEntity());
        Mockito.when(itemService.save(ArgumentMatchers.any(Item.class))).thenReturn(ItemBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(ItemBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(itemService, Mockito.times(1)).save(ArgumentMatchers.any(Item.class));
        Mockito.verifyNoMoreInteractions(itemService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(itemMapper.asEntity(ArgumentMatchers.any())).thenReturn(ItemBuilder.getEntity());
        Mockito.when(itemService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInteger())).thenReturn(ItemBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(ItemBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(itemService, Mockito.times(1)).update(ArgumentMatchers.any(Item.class), ArgumentMatchers.anyInteger());
        Mockito.verifyNoMoreInteractions(itemService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(itemService).deleteById(ArgumentMatchers.anyInteger());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(itemService, Mockito.times(1)).deleteById(Mockito.anyInteger());
        Mockito.verifyNoMoreInteractions(itemService);
    }