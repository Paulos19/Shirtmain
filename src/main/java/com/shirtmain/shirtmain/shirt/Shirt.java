package com.shirtmain.shirtmain.shirt;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "shirt")
@Entity(name = "shirt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Shirt {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String image;
    private Integer price;

    public Shirt(ShirtRequestDTO data){
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
