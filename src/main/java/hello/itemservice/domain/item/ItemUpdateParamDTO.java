package hello.itemservice.domain.item;

import lombok.Data;

@Data
public class ItemUpdateParamDTO {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemUpdateParamDTO() {
    }

    public ItemUpdateParamDTO(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
