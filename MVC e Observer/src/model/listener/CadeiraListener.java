package src.model.listener;

import java.util.EventListener;
import src.model.source.CadeiraEvent;

public interface CadeiraListener extends EventListener {
    public void mudancaNasCadeiras(CadeiraEvent event);
}
