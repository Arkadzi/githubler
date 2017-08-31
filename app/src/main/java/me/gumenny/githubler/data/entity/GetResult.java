package me.gumenny.githubler.data.entity;

import java.util.List;

public class GetResult<T> {
    private List<T> items;

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }
}
