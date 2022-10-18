package com.ahmed.fullproject.controller.impl;

import com.ahmed.fullproject.controller.impl.AccountControllerImpl;
import com.ahmed.fullproject.controller.impl.CustomUtils;
import com.ahmed.fullproject.dto.AccountDTO;
import com.ahmed.fullproject.entity.Account;
import com.ahmed.fullproject.mapper.AccountMapper;
import com.ahmed.fullproject.mapper.ReferenceMapper;
import com.ahmed.fullproject.service.AccountService;
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
public class AccountControllerImplTest {
    //TODO: create the data Test generator class AccountBuilder
    private static final String ENDPOINT_URL = "/accounts";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AccountControllerImpl accountController;
    @MockBean
    private AccountService accountService;
    @MockBean
    private AccountMapper accountMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.accountController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(accountMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AccountBuilder.getListDTO());

        Mockito.when(accountService.findAll()).thenReturn(AccountBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(accountMapper.asDTO(ArgumentMatchers.any())).thenReturn(AccountBuilder.getDTO());

        Mockito.when(accountService.findById(ArgumentMatchers.anyInteger())).thenReturn(java.util.Optional.of(AccountBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(accountService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(accountService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(accountMapper.asEntity(ArgumentMatchers.any())).thenReturn(AccountBuilder.getEntity());
        Mockito.when(accountService.save(ArgumentMatchers.any(Account.class))).thenReturn(AccountBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(AccountBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(accountService, Mockito.times(1)).save(ArgumentMatchers.any(Account.class));
        Mockito.verifyNoMoreInteractions(accountService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(accountMapper.asEntity(ArgumentMatchers.any())).thenReturn(AccountBuilder.getEntity());
        Mockito.when(accountService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInteger())).thenReturn(AccountBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(AccountBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(accountService, Mockito.times(1)).update(ArgumentMatchers.any(Account.class), ArgumentMatchers.anyInteger());
        Mockito.verifyNoMoreInteractions(accountService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(accountService).deleteById(ArgumentMatchers.anyInteger());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(accountService, Mockito.times(1)).deleteById(Mockito.anyInteger());
        Mockito.verifyNoMoreInteractions(accountService);
    }