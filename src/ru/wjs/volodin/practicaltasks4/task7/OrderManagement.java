package ru.wjs.volodin.practicaltasks4.task7;

import java.time.LocalDateTime;

public interface OrderManagement {
    /**
     * Сборка товара.
     * <p>
     * Устанавливает статус COLLECTED.
     */
    void assembleOrder();
    /**
     * Выдача заказа.
     * <p>
     * Устанавливает статус CLOSED.
     */
    void giveOrder();
    OrderStatus getOrderStatus();

    /**
     * @return время сборки товара.
     */
    LocalDateTime getOrderAssemblyDateTime(); // время сборки

}

