package it.valeriovaudi.emarket.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mrflick72 on 09/05/17.
 */

@Data
@Document
public class PriceList implements Serializable {


    @Id
    private String id;

    private String name;

    private List<GoodsInPriceList> goodsInPriceList;
}
