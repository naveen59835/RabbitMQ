/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class User {
    @Id
    String userId;
    String password;

}
