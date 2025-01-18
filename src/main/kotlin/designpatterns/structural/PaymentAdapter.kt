package dev.janku.learning.designpatterns.structural

import java.math.BigDecimal

/**
 * Showcase of the Adapter pattern (structural)
 * - use to make two incompatible interfaces compatible
 *
 * Example:
 * We have an existing payment system "OldPaymentSystem" which accepted only USD payments and the API was not very user-friendly.
 * The new system has broader options and uses a different currency and account format (objects over strings).
 *
 * In order to keep the backward compatibility while introducing the new system we create an adapter which
 * will translate the new API to the old one. That way we can uyse the new system through PaymentGateway everywhere
 * while keeping the old system in place.
 */
class OldPaymentSystemAdapter(val oldPaymentSystem : OldPaymentSystem) : PaymentGateway  {
  override fun pay(paymentDetails: Payment) {
    require(paymentDetails.currency == Payment.Currency.USD) { "Only USD payments are supported" }

    val account = "${paymentDetails.accountTo.prefix}-${paymentDetails.accountTo.number}/${paymentDetails.accountTo.bankCode}"
    oldPaymentSystem.pay(paymentDetails.amount.toDouble(), account)
  }
}

/** Account representation */
data class Account(val prefix: String, val number: String, val bankCode: String)

/** Payment representation including supported currencies */
data class Payment(val amount: BigDecimal, val currency: Currency, val accountTo: Account) {
  enum class Currency {
    USD, EUR, CZK
  }
}

/** The new payment system API */
interface PaymentGateway {
  /**
   * Pay the given amount using the given account
   * @param paymentDetails - payment details (amount, account, currency, ...)
   */
  fun pay(paymentDetails: Payment)
}

/** The @deprecated payment system API */
@Deprecated("Use the new PaymentGateway instead", level = DeprecationLevel.WARNING, replaceWith = ReplaceWith("PaymentGateway"))
interface OldPaymentSystem {
  /**
   * Pay the given amount using the given account
   * @param amount - amount to pay
   * @param account - account number in the format "prefix-number/bankCode"
   */
  fun pay(amount: Double, account: String)
}

fun  main() {
  val paymentSystem : PaymentGateway = OldPaymentSystemAdapter(object : OldPaymentSystem {
    override fun pay(amount: Double, account: String) {
      println("Paying \$$amount to $account using the old system")
    }
  })

  paymentSystem.pay(Payment(BigDecimal.TEN, Payment.Currency.USD, Account("00024", "11828313", "0800")))
}