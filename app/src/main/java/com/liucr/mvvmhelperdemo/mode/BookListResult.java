package com.liucr.mvvmhelperdemo.mode;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by liucr on 2018/4/25.
 */
public class BookListResult extends BaseListData {

    @SerializedName("books")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookListResult{" +
                "books=" + books +
                '}';
    }
}
