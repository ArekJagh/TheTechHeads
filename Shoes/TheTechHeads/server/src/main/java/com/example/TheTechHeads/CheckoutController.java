package com.example.TheTechHeads;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @PostMapping
    public Map<String, Object> processPayment(@RequestBody Map<String, Object> paymentDetails) {
        String cardNumber = (String) paymentDetails.get("cardNumber");
        String expiryDate = (String) paymentDetails.get("expiryDate");
        String cvv = (String) paymentDetails.get("cvv");

        if (cardNumber != null && expiryDate != null && cvv != null) {
            return Map.of("success", true, "message", "Payment successful");
        } else {
            return Map.of("success", false, "message", "Payment failed");
        }
    }
}
