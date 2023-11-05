package ru.wjs.volodin.practicaltask4.task7;

import org.junit.Assert;
import org.junit.Test;
import ru.wjs.volodin.practicalTasks3.task5.Catalog;
import ru.wjs.volodin.practicalTasks3.task5.baseclasses.Product;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedrefrigerators.ImportFridge;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedrefrigerators.ImportFridgeWithFreezingChamber;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedstoves.ImportElecticStove;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedwashingmachines.ImportWashingMachine;
import ru.wjs.volodin.practicalTasks3.task5.products.refrigerators.Fridge;
import ru.wjs.volodin.practicalTasks3.task5.products.refrigerators.MiniFridge;
import ru.wjs.volodin.practicalTasks3.task5.products.stoves.ElectricStove;
import ru.wjs.volodin.practicalTasks3.task5.products.stoves.GasStove;
import ru.wjs.volodin.practicalTasks3.task5.products.washingMachines.WashingMachine;
import ru.wjs.volodin.practicalTasks3.task5.products.washingMachines.WashingMachineDryer;
import ru.wjs.volodin.practicaltasks4.task7.Order;
import ru.wjs.volodin.practicaltasks4.task7.OrderExpirationException;
import ru.wjs.volodin.practicaltasks4.task7.OrderStatus;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OrderTest {
    /**
     * Тест, проверяющий работу метода checkAndSetOrderExpiration(), который
     * может проверить не истёк ли срок хранения заказа и, если истёк, установит ему соответствующий статус.
     */
    @Test
    public void testCheckAndSetOrderExpiration() {
        Fridge fridge = new Fridge(80_000, "Холодильник...", 65, 32, 70, "Черный",
                "Россия", true, 0, 8);
        Order testOrder = new Order("Valery", "89193412871", fridge);
        testOrder.generateMessage();// уведомление присылается ~ сразу после сборки товара.
        testOrder.setDateTimeOrderAssembly(LocalDateTime.now().minusWeeks(3)); // устанавливаем дату сбора на 3 недели до
        assertTrue(testOrder.checkAndSetOrderExpiration()); // для сравнения с сегодняшней датой.
        Assert.assertEquals(OrderStatus.EXPIRED, testOrder.getOrderStatus());

        Order testOrder1 = new Order("Valery", "89193412872", fridge);
        testOrder1.generateMessage();
        testOrder1.setDateTimeOrderAssembly(LocalDateTime.now().minusWeeks(2)); // проверим, можно ли забрать в последний день
        assertFalse(testOrder1.checkAndSetOrderExpiration());
        assertEquals(OrderStatus.COLLECTED, testOrder1.getOrderStatus());
    }

    /**
     * Тест, проверяющий метод, который бы работал по следующей логике:
     * <p> * если заказ пока не собран, то получение недоступно, метод возвращает false
     * <p> * если заказ уже собран и срок его хранения пока не вышел, то заказ доступен для получения, метод возвращает true
     * <p> * если заказ собран, но срок хранения истёк, то метод бросает исключение
     */
    @Test
    public void checkIsReadyForPickUp() {
        Fridge fridge = new Fridge(80_000, "Холодильник...", 65, 32, 70, "Черный",
                "Россия", true, 0, 8);

        Order testOrder = new Order("Valery", "89193412871", fridge);
        assertFalse(testOrder.isReadyForPickup()); // до сборки заказа забрать его нельзя
        assertEquals(OrderStatus.CREATED, testOrder.getOrderStatus());

        testOrder.generateMessage();// уведомление присылается ~ сразу после сборки заказа.
        assertEquals(OrderStatus.COLLECTED, testOrder.getOrderStatus());
        assertTrue(testOrder.isReadyForPickup()); // собранный заказ можно забрать после получения сообщения.

        testOrder.setDateTimeOrderAssembly(LocalDateTime.now().minusWeeks(3)); // устанавливаем дату сбора на 3 недели до
        assertThrows(OrderExpirationException.class, testOrder::isReadyForPickup);// выкинет исключение, если заказ собран,
        // но срок его хранения истёк ( testOrder:: - подсказала ide)

    }

    /**
     * Тест, проверяющий сборку заказа методом assembleOrder().
     */
    @Test
    public void checkAssembleOrder() {
        Fridge fridge = new Fridge(80_000, "Холодильник...", 65, 32, 70, "Черный",
                "Россия", true, 0, 8);

        Order testOrder = new Order("Valery", "89193412871", fridge);
        assertEquals(OrderStatus.CREATED, testOrder.getOrderStatus());
        testOrder.assembleOrder();
        assertEquals(OrderStatus.COLLECTED, testOrder.getOrderStatus());
    }

    /**
     * Тест, проверяющий закрытие заказа после его выдачи методом giveOrder().
     */
    @Test
    public void checkGiveOrder() {
        Fridge fridge = new Fridge(80_000, "Холодильник...", 65, 32, 70, "Черный",
                "Россия", true, 0, 8);

        Order testOrder = new Order("Valery", "89193412871", fridge);
        testOrder.generateMessage();
        assertEquals(OrderStatus.COLLECTED, testOrder.getOrderStatus());
        testOrder.giveOrder();
        assertEquals(OrderStatus.CLOSED, testOrder.getOrderStatus());
    }

}
