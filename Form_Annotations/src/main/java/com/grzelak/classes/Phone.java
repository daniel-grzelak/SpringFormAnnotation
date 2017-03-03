package com.grzelak.classes;

import com.grzelak.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
public class Phone {
    @Model
    private String model;
    @ProducerList
    private List<Producer> producers;
    @Screen(min = 4)
    private Double screen;
    @Price
    private Double price;
    private List<Component> components;
    @Multipart
    private MultipartFile multipartFile;
    private String multipartFilename;

    public Phone() {

    }

    public Phone(String model, List<Producer> producers, Double screen, Double price, List<Component> components, MultipartFile multipartFile, String multipartFilename) {
        this.model = model;
        this.producers = producers;
        this.screen = screen;
        this.price = price;
        this.components = components;
        this.multipartFile = multipartFile;
        this.multipartFilename = multipartFilename;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public Double getScreen() {
        return screen;
    }

    public void setScreen(Double screen) {
        this.screen = screen;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getMultipartFilename() {
        return multipartFilename;
    }

    public void setMultipartFilename(String multipartFilename) {
        this.multipartFilename = multipartFilename;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", producers='" + producers + '\'' +
                ", screen=" + screen +
                ", price=" + price +
                ", components=" + components +
                ", multipartFile=" + multipartFile +
                ", multipartFilename='" + multipartFilename + '\'' +
                '}';
    }
}
