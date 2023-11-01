package ru.wjs.volodin.practicaltasks4.task7;

import java.time.LocalDateTime;

public interface OrderManagement {
    boolean isReadyForPickup(); // проверка заказа на готовность к получению
    void assembleOrder(); // сборка
    void giveOrder();
    String getOrderStatus();
    LocalDateTime getOrderAssemblyDateTime(); // время сборки

}

