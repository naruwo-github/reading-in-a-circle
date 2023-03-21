interface OrderState {
    cancelOrder(): void;
    verifyPayment(): void;
    shipOrder(): void;
}

class OrderContext implements OrderState {
    private currentState: OrderState;

    constructor() {
        this.transitionTo(new OrderPendingState());
    }

    public transitionTo(state: OrderState): void {
        console.log(`OrderContext: Transition to ${(<any>state).constructor.name}.`);
        this.currentState = state;
        this.currentState.cancelOrder();
        this.currentState.verifyPayment();
        this.currentState.shipOrder();
    }

    public cancelOrder(): void {
        this.currentState.cancelOrder();
    }

    public verifyPayment(): void {
        this.currentState.verifyPayment();
    }

    public shipOrder(): void {
        this.currentState.shipOrder();
    }
}

class OrderPendingState implements OrderState {
    public cancelOrder(): void {
        console.log("OrderPendingState: Canceling order.");
    }

    public verifyPayment(): void {
        console.log("OrderPendingState: Verifying payment.");
    }

    public shipOrder(): void {
        console.log("OrderPendingState: Cannot ship order until payment is verified.");
    }
}

class OrderVerifiedState implements OrderState {
    public cancelOrder(): void {
        console.log("OrderVerifiedState: Canceling order.");
    }

    public verifyPayment(): void {
        console.log("OrderVerifiedState: Payment has already been verified.");
    }

    public shipOrder(): void {
        console.log("OrderVerifiedState: Shipping order.");
    }
}

class OrderCanceledState implements OrderState {
    public cancelOrder(): void {
        console.log("OrderCanceledState: Order has already been canceled.");
    }

    public verifyPayment(): void {
        console.log("OrderCanceledState: Payment verification not possible.");
    }

    public shipOrder(): void {
        console.log("OrderCanceledState: Cannot ship canceled order.");
    }
}

const orderContext = new OrderContext();
orderContext.verifyPayment();
orderContext.transitionTo(new OrderVerifiedState());
orderContext.shipOrder();
orderContext.transitionTo(new OrderCanceledState());
orderContext.cancelOrder();