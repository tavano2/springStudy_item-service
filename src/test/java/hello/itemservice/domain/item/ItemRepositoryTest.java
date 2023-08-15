package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("itemA", 10000, 10);
        // when
        Item savedItem = itemRepository.save(item);
        // then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);

    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 10000, 10);
        itemRepository.save(item1);
        itemRepository.save(item2);
        // when
        List<Item> items = itemRepository.findAll();
        // then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1, item2);
    }

    @Test
    void updateItem() {
        // given
        Item item1 = new Item("itemA", 10000, 10);
        itemRepository.save(item1);
        // when
        Item findId = itemRepository.findById(item1.getId());
        ItemUpdateParamDTO updateDTO = new ItemUpdateParamDTO("itemB",20000, 20);
        itemRepository.update(findId.getId(), updateDTO);
        // then
        Item resultItem = itemRepository.findById(findId.getId());
        assertThat(resultItem.getItemName()).isEqualTo(updateDTO.getItemName());
        assertThat(resultItem.getPrice()).isEqualTo(updateDTO.getPrice());
        assertThat(resultItem.getQuantity()).isEqualTo(updateDTO.getQuantity());

    }

}