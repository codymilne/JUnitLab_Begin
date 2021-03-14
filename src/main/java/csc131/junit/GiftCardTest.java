package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiftCardTest {

	@Test
	public void getIssuingStore()
	 {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore ()",
					 issuingStore, card.getIssuingStore());
	 }
	@Test
	public void getBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance ()",
					 balance, card.getBalance(),0.001);
	}
	@Test
	public void deduct_RemainingBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		String expected1 = ("Remaining Balance:   0.00");
		String expected2 = ("Invalid Transaction");
		String expected3 = ("Amount Due: 120.00");
		
		card = new GiftCard(issuingStore, balance);
		
		String result1 = card.deduct(balance);
		String result2 = card.deduct(-20.00);
		String result3 = card.deduct(120.00);
		
		assertEquals("deduct_RemainingBalance()",
					expected1, result1);
		assertEquals("deduct_RemainingBalance()",
				expected2, result2);
		assertEquals("deduct_RemainingBalance()",
				expected3, result3);
		
		
	}
	@Test
	public void illegalBalance() {
		
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
		
	}
	

	@Test
	public void constructor_IncorrectID_Low()  {
		
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100);});
	}
	
	@Test
	public void constructor_IncorrectID_High()  {
		
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100);});
	}
}
