package br.com.loja.dto;

import java.util.List;

import br.com.loja.dto.OrderDtos.ItemInput;
import br.com.loja.validation.PositiveIdentifier;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public final class PublicCheckoutDtos {
    private PublicCheckoutDtos() {
    }

    public record CheckoutAddressInput(
        @NotBlank @Size(max = 20) String postalCode,
        @NotBlank @Size(max = 200) String street,
        @NotBlank @Size(max = 10) String number,
        @Size(max = 200) String complement,
        @NotBlank @Size(max = 100) String district,
        @NotBlank @Size(max = 100) String city,
        @NotBlank @Size(min = 2, max = 2) String state
        
    ){}

    public record IdentifiedCustomerView(
        String id,
        String name,
        String phone,
        List<CustomerAddressView> addresses
    ){}

    public record CustomerAddressView(
        String id,
        String postalCode,
        String street,
        String number,
        String complement,
        String district,
        String city,
        String state
    ){}

    public record PublicOrderInput(
        @NotBlank @Size(min =2, max = 255) String customerName,
        @NotBlank String customerPhone,
        LocalDate customerBirthDay,
        @NotBlank @Pattern (regexp = "PIX|CASH|BOLETO|INSTALMENT") String paymentMethod,
        @Min (1) @Max (12) Integer installmentCount,
        boolean delivery,
        @PositiveIdentifier String addressId,
        @Valid CheckoutAddressInput newAddress,
        @Size(max = 255) String couponCode,
        @NotEmpty @Size(max = 100) List<@NotNull @Valid ItemInput> items
    ){}
    

}
