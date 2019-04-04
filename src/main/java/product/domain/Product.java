package product.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 商品情報オブジェクトです。
 * 
 * @author koujienami
 */
public class Product {

	/** 商品ID */
	@NotBlank
	private String id;

	/** 名前 */
	@NotBlank
	private String name;

	/** 金額 */
	@NotBlank
	@Min(0)
	@Max(10000)
	private int amount;

	/** 購入可否 */
	@NotBlank
	private boolean salesAvailability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isSalesAvailability() {
		return salesAvailability;
	}

	public void setSalesAvailability(boolean salesAvailability) {
		this.salesAvailability = salesAvailability;
	}
}
