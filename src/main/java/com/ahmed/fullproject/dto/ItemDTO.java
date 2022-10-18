package com.ahmed.fullproject.dto;

public class ItemDTO extends AbstractDTO<Integer> {
    private Integer itemId;
    private String name;
    private String type;

    public ItemDTO() {
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return this.itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}