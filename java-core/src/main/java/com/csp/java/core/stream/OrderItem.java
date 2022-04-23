package com.csp.java.core.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chensiping
 * @since 2021-01-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Long productId;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
}
