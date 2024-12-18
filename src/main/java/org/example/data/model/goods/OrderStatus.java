package org.example.data.model.goods;

import org.springframework.stereotype.Component;

public enum OrderStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    CONFIRMED,
    CANCELED,
    RETURNED
}
