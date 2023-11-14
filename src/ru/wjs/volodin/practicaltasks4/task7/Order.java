package ru.wjs.volodin.practicaltasks4.task7;

import ru.wjs.volodin.practicalTasks3.task5.baseclasses.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Order implements OrderManagement, OrderChecker {

    private String orderNumber;
    protected LocalDateTime dateTimeOrderReceipt, dateTimeOrderAssembly, dateTimeOrderDelivery;
    private Product[] orderComposition;
    private String clientName;
    private String clientPhoneNumber;
    private BigDecimal sumOfOrderComposition = new BigDecimal(0);
    private OrderStatus orderStatus;

    public Order(String clientName, String clientPhoneNumber, Product... orderComposition) {
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.dateTimeOrderReceipt = LocalDateTime.now();
        this.orderNumber = generateOrderNumber();
        if (orderComposition.length <= 75) {
            this.orderComposition = orderComposition;
        } else {
            throw new IllegalArgumentException("Превышен лимит в 75 позиций заказа");
        }
        this.orderStatus = OrderStatus.CREATED;
    }
    public void setDateTimeOrderAssembly(LocalDateTime testDateTime){
        this.dateTimeOrderAssembly= testDateTime;
    }

    private String generateSumOfOrderComposition() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        format.setMaximumFractionDigits(2);
        format.setRoundingMode(RoundingMode.UP);
        for (Product productOrder : orderComposition) {
            BigDecimal productPrice = new BigDecimal(productOrder.getPrice());
            sumOfOrderComposition = sumOfOrderComposition.add(productPrice);
        }
        return format.format(sumOfOrderComposition);
    }

    private String generateOrderNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String time = dateTimeOrderReceipt.format(formatter);
        String remakeOrderNumber = clientPhoneNumber.substring(clientPhoneNumber.length() - 4);
        return time + remakeOrderNumber;
    }

    public String generateMessage() {
        assembleOrder();
        LocalDate deliveryDate = dateTimeOrderAssembly.toLocalDate().plusWeeks(2);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDeliveryDate = deliveryDate.format(dateFormatter);

        StringBuilder textOfMessage = new StringBuilder();
        textOfMessage.append("Уважаемый ").append(clientName).append("!\n");
        textOfMessage.append("Рады сообщить, что Ваш заказ ").append(orderNumber).append(" готов к выдаче.\n");
        textOfMessage.append("Состав заказа:\n");
        for (Product item : orderComposition) {
            textOfMessage.append(item).append("\n");
        }
        textOfMessage.append("Сумма к оплате: ").append(generateSumOfOrderComposition()).append(".\n");
        textOfMessage.append("Срок хранения заказа ").append(formattedDeliveryDate).append(".\n");
        textOfMessage.append("С наилучшими пожеланиями, магазин “Кошки и картошки”");

        return textOfMessage.toString();
    }


    @Override
    public boolean isReadyForPickup() {
        if (!(orderStatus == OrderStatus.CREATED)) {
            if (orderStatus == OrderStatus.COLLECTED) {
                if (!checkAndSetOrderExpiration()) {
                    return true;
                } else {
                    throw new OrderExpirationException("Срок годности товара истёк");
                }
            }
        }
        return false;
    }

    @Override
    public void assembleOrder() {
        dateTimeOrderAssembly = LocalDateTime.now();
        orderStatus = OrderStatus.COLLECTED;
    }

    @Override
    public void giveOrder() {
        orderStatus = OrderStatus.CLOSED;
        dateTimeOrderDelivery = LocalDateTime.now();
    }

    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public LocalDateTime getOrderAssemblyDateTime() {
        return dateTimeOrderAssembly;
    }

    @Override
    public boolean checkAndSetOrderExpiration() { // это ведь нарушает принцип единственной ответственности?
        LocalDate expirationDate = dateTimeOrderAssembly.toLocalDate().plusWeeks(2);
        if (LocalDate.now().isAfter(expirationDate)) {
            orderStatus = OrderStatus.EXPIRED;
            return true;
        }
        return false;
    }
}






