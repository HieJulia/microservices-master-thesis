package it.valeriovaudi.emarket.repository;

import it.valeriovaudi.emarket.model.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mrflick72 on 09/05/17.
 */

public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, String> {

}