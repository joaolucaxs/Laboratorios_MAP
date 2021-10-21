package src.model.source;

import java.util.List;
import java.util.ArrayList;

import src.model.listener.CadeiraListener;

public class Cadeira {
    public final static int Disponivel = 0;
    public final static int Reservado = 1;
    public final static int Indisponivel = 2;
    
    private int acento;
    private List<CadeiraListener> cadeiraListeners; 

    public Cadeira() {
        this.acento = 0;
        this.cadeiraListeners = new ArrayList<CadeiraListener>();
    }

    public int getAcento() {
        return this.acento;
    }
    
    public void setAcento(int estado) {
        this.acento = estado;
        dispararMudancaNasCadeiras();
    }

    public List<CadeiraListener> getCadeiraListeners() {
        return cadeiraListeners;
    }

    public synchronized void addCadeiraListener(CadeiraListener listener) {
        if (!cadeiraListeners.contains(listener)) {
            cadeiraListeners.add(listener);
        }
    }

    public synchronized void removeCadeiraListener(CadeiraListener listener) {
        cadeiraListeners.remove(listener);
    }


    @SuppressWarnings("unchecked")
    private void dispararMudancaNasCadeiras() {
        List<CadeiraListener> cadeiraListener;

        synchronized (this) {
            cadeiraListener = (List<CadeiraListener>) (((ArrayList) cadeiraListeners).clone());
        }
        CadeiraEvent cadeiraEvent = new CadeiraEvent(this);
        for (CadeiraListener listener : cadeiraListener) {
            listener.mudancaNasCadeiras(cadeiraEvent);
        }
    }
}
