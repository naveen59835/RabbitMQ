/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    String productId;
    String productName;
    boolean productInStock;


}
