package ru.wjs.volodin.practicaltasks4.task7;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order implements OrderManagement {
    public enum OrderStatus {
        CREATED,
        COLLECTED,
        EXPIRED,
        CLOSED
    }


    private String orderNumber;
    private LocalDateTime dateTimeOrderReceipt, dateTimeOrderAssembly, getDateTimeOrderDelivery;
    private String[] orderComposition;
    private String clientName;
    private String clientPhoneNumber;

    public Order(String clientName, String clientPhoneNumber, String... orderComposition) {
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.orderComposition = orderComposition;
        this.dateTimeOrderReceipt = LocalDateTime.now();
        this.dateTimeOrderAssembly = LocalDateTime.now();//
        this.orderNumber = generateOrderNumber();
    }

    private String generateOrderNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String time = dateTimeOrderReceipt.format(formatter);
        String remakeOrderNumber = clientPhoneNumber.substring(clientPhoneNumber.length() - 4);
        return time + remakeOrderNumber;
    }

    public String generateMessage() {
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        format.setRoundingMode(RoundingMode.UP);

        LocalDate deliveryDate = dateTimeOrderAssembly.toLocalDate().plusWeeks(2);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDeliveryDate = deliveryDate.format(dateFormatter);

        StringBuilder textOfMessage = new StringBuilder();
        textOfMessage.append("Уважаемый ").append(clientName).append("!\n");
        textOfMessage.append("Рады сообщить, что Ваш заказ ").append(orderNumber).append(" готов к выдаче.\n");
        textOfMessage.append("Состав заказа:\n");
        for (String item : orderComposition) {
            textOfMessage.append(item).append("\n");
        }
        textOfMessage.append("Сумма к оплате: ").append("₽\n");// .append(sumOfOrderComposition);
        textOfMessage.append("Срок хранения заказа ").append(formattedDeliveryDate).append(".\n");
        textOfMessage.append("С наилучшими пожеланиями, магазин “Кошки и картошки”");

        return textOfMessage.toString();
    }

    @Override
    public boolean isReadyForPickup() {



        return false;
    }

    @Override
    public void assembleOrder() {

    }

    @Override
    public void giveOrder() {

    }

    @Override
    public String getOrderStatus() {



        return null;
    }

    @Override
    public LocalDateTime getOrderAssemblyDateTime() {
        return null;
    }


    private void setOrderStatus(OrderStatus orderStatus) {

    }
}







