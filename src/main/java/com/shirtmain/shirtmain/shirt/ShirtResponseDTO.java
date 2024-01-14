package com.shirtmain.shirtmain.shirt;

public record ShirtResponseDTO(String id, String title, String image, Integer price) {
    public ShirtResponseDTO(Shirt shirt){
        this(shirt.getId(), shirt.getTitle(), shirt.getImage(), shirt.getPrice());
    }
}
