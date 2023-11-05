package ru.wjs.volodin.practicaltasks4.task7;

public interface OrderChecker {
    /**
     * Проверяет возможность получения заказа в зависимости от его статуса.
     *
     * @return Возможность получения заказа.
     * <p> При COLLECTED с истекшим сроком - бросает исключение OrderExpirationException
     */
    boolean isReadyForPickup() throws OrderExpirationException;

    /**
     * Проверка заказа на истечение срока хранения.
     * <p>
     * При истечении - устанавливает соответсвующий статус.
     * @return true - товар истёк, false - ещё нет.
     */
    boolean checkAndSetOrderExpiration();

}