package com.kohls.pce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class PriceChange implements Serializable {
	
	public String eventCategoryCode;
	public String priceChangeTypeCode;
	public String eventCode;
	public Date eventDate;
	public String strNo;
	public String skuNo;
	public BigDecimal expectedQuantity;
	public BigInteger secondaryQuantity;
	public BigInteger priceChangeId;
	public BigDecimal newUnitRetailAmount;
	public BigInteger newGroupRetailAmount;
	public BigDecimal newGroupOtherAmount;
	
	@Override
	public String toString() {
		return "PriceChange [eventCategoryCode=" + eventCategoryCode + ", priceChangeTypeCode=" + priceChangeTypeCode
				+ ", eventCode=" + eventCode + ", eventDate=" + eventDate + ", strNo=" + strNo + ", skuNo=" + skuNo
				+ ", expectedQuantity=" + expectedQuantity + ", secondaryQuantity=" + secondaryQuantity
				+ ", priceChangeId=" + priceChangeId + ", newUnitRetailAmount=" + newUnitRetailAmount
				+ ", newGroupRetailAmount=" + newGroupRetailAmount + ", newGroupOtherAmount=" + newGroupOtherAmount
				+ "]";
	}
	
	public String getEventCategoryCode() {
		return eventCategoryCode;
	}
	public void setEventCategoryCode(String eventCategoryCode) {
		this.eventCategoryCode = eventCategoryCode;
	}
	public String getPriceChangeTypeCode() {
		return priceChangeTypeCode;
	}
	public void setPriceChangeTypeCode(String priceChangeTypeCode) {
		this.priceChangeTypeCode = priceChangeTypeCode;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getStrNo() {
		return strNo;
	}
	public void setStrNo(String strNo) {
		this.strNo = strNo;
	}
	public String getSkuNo() {
		return skuNo;
	}
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	public BigDecimal getExpectedQuantity() {
		return expectedQuantity;
	}
	public void setExpectedQuantity(BigDecimal expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}
	public BigInteger getSecondaryQuantity() {
		return secondaryQuantity;
	}
	public void setSecondaryQuantity(BigInteger secondaryQuantity) {
		this.secondaryQuantity = secondaryQuantity;
	}
	public BigInteger getPriceChangeId() {
		return priceChangeId;
	}
	public void setPriceChangeId(BigInteger priceChangeId) {
		this.priceChangeId = priceChangeId;
	}
	public BigDecimal getNewUnitRetailAmount() {
		return newUnitRetailAmount;
	}
	public void setNewUnitRetailAmount(BigDecimal newUnitRetailAmount) {
		this.newUnitRetailAmount = newUnitRetailAmount;
	}
	public BigInteger getNewGroupRetailAmount() {
		return newGroupRetailAmount;
	}
	public void setNewGroupRetailAmount(BigInteger newGroupRetailAmount) {
		this.newGroupRetailAmount = newGroupRetailAmount;
	}
	public BigDecimal getNewGroupOtherAmount() {
		return newGroupOtherAmount;
	}
	public void setNewGroupOtherAmount(BigDecimal newGroupOtherAmount) {
		this.newGroupOtherAmount = newGroupOtherAmount;
	}
}