package it.valeriovaudi.emarket.event.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.UserDefinedType;

import java.util.Date;

/**
 * Created by mrflick72 on 03/05/17.
 */

@Data
@ToString(callSuper = true)
@UserDefinedType("eventAuditData")
public class EventAuditData {

    private String correlationId;
    private String userName;
    private Date timeStamp;
}
