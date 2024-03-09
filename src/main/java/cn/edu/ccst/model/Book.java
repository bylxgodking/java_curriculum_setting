package cn.edu.ccst.model;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/9:36
 * @Description:
 */
public class Book {
    private String id;
    private String name;
    private String type;
    private String author;
    private String publisher;
    private double price;
    private String abstractText;
    private String status;
    private String mark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", abstractText='" + abstractText + '\'' +
                ", status='" + status + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    public Book() {}

    public Book(String id, String name, String type, String author, String publisher, double price, String abstractText, String status, String mark) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.abstractText = abstractText;
        this.status = status;
        this.mark = mark;
    }
}
