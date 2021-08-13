package com.leverx.cap.test.handler;

import cds.gen.com.leverx.cap.test.Owners_;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import org.springframework.stereotype.Component;

import static com.sap.cds.services.cds.CdsService.EVENT_CREATE;

/**
 * @author Valeryia Zubrytskaya
 */

@Component
@ServiceName(Owners_.CDS_NAME)
public class OwnersEventHandler implements EventHandler {

    @On(event = EVENT_CREATE, entity = Owners_.CDS_NAME)
    public void onOwnerCreate(CdsCreateEventContext context) {
        context.getCqn().entries().forEach(e -> products.put(e.get("ID"), e));

        context.setResult(context.getCqn().entries());
    }

}
