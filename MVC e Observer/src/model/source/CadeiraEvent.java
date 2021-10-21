package src.model.source;

import java.util.EventObject;

public class CadeiraEvent extends EventObject {
    public CadeiraEvent(Cadeira source) {
        super(source);
    }
}
