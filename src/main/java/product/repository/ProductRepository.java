package product.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import product.domain.Product;

import java.util.List;

/**
 * 商品を扱うリポジトリです。<br/>
 * 実体は{@link product.domain.Product}とDBテーブル(product)を紐づける為のORMクラスです。
 * 
 * @author koujienami
 */
@Mapper
public interface ProductRepository {

	/**
	 * 商品の一覧を取得します。
	 * 
	 * @return 商品の一覧
	 */
	@Select("SELECT * FROM product ORDER BY id ASC")
	List<Product> select();
	
}
