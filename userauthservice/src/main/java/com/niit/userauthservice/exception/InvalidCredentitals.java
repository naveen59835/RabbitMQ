/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Invalid credentials" )
public class InvalidCredentitals extends Exception {
}
