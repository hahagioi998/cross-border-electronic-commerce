package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TransactionInfo {
    /**
     * 交易信息。
     */
    @JsonProperty("paypal_account_id")
    private String paypalAccountId;

    /**
     * PayPal 生成的交易 ID
     */
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * 个五位数的交易事件代码，根据资金流动和借记或贷记对交易类型进行分类
     * https://developer.paypal.com/docs/transaction-search/transaction-event-codes/
     */
    @JsonProperty("transaction_event_code")
    private String transactionEventCode;

    /**
     * 在 PayPal 系统中开始处理交易的日期和时间，以付款这一方的帐户时区表示
     */
    @JsonProperty("transaction_initiation_date")
    private String transactionInitiationDate;

    /**
     * 上次更改交易的日期和时间，以付款这边账户的时区表示。
     */
    @JsonProperty("transaction_updated_date")
    private String transactionUpdatedDate;

    /**
     * 通过 PayPal 在发送方和接收方之间转移的全包交易总额。
     */
    @JsonProperty("transaction_amount")
    private TransactionAmount transactionAmount;

    /**
     * PayPal 费用金额
     */
    @JsonProperty("fee_amount")
    private TransactionAmount feeAmount;

    /**
     * 一笔保险费。保证产品的质量或交付。
     */
    @JsonProperty("insurance_amount")
    private TransactionAmount insuranceAmount;

    /**
     * PayPal 或商家报告的交易运费。
     */
    @JsonProperty("shipping_amount")
    private TransactionAmount shippingAmount;

    /**
     * 运费折扣。
     */
    @JsonProperty("shipping_discount_amount")
    private TransactionAmount shippingDiscountAmount;

    /**
     * 交易状态的代码
     * D	PayPal 或商家规则拒绝交易。
     * P	交易待定。交易已创建，但在状态更改为 之前等待另一个支付流程完成，例如 ACH 交易S。
     * S	交易成功完成，没有拒绝并且在任何未决状态之后。
     * V	成功的交易被完全撤销，资金被退还给原始发件人。
     */
    @JsonProperty("transaction_status")
    private String transactionStatus;

    /**
     * 付款的主体。付款人将此值传递给收款人。付款人通过他或她发送数据的接口来控制这些数据。
     */
    @JsonProperty("transaction_subject")
    private String transactionSubject;

    /**
     * 付款人传递给收款人的特殊说明。可能包含特殊的客户要求，例如运输说明。
     */
    @JsonProperty("transaction_note")
    private String transactionNote;

    /**
     * 商家随交易发送的发票 ID。
     * 注意：如果发票 ID 与请款请求一起发送，则会报告该值。否则，上报授权交易的发票编号。
     */
    @JsonProperty("invoice_id")
    private String invoiceId;

    /**
     * 商家提供的自定义文本。
     * 注意：通常，此字段包含使用 MassPay 类型交易进行的付款的唯一 ID。
     */
    @JsonProperty("custom_field")
    private String customField;

    /**
     * 交易是否有资格获得保护
     * 01. 有资格的。
     * 02. 不容忽视
     * 03. 部分合格。
     */
    @JsonProperty("protection_eligibility")
    private String protectionEligibility;
}
