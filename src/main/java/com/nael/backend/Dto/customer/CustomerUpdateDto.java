package com.nael.backend.Dto.customer;

public class CustomerUpdateDto {
    private Integer id;
    private String name;
    private String number;

    public CustomerUpdateDto() {
    }

    public CustomerUpdateDto(Integer id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
