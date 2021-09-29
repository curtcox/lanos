@Grab('io.socket:socket.io-client:2.0.0')
import io.socket.client.*
import io.socket.emitter.*

Socket socket = IO.socket("http://localhost:3000/")

socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
    @Override
    public void call(Object... args) {
        System.out.println('EVENT_CONNECT')
        System.out.println(socket.id())
    }
})

socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
    @Override
    public void call(Object... args) {
      System.out.println('EVENT_CONNECT_ERROR')
    }
})

socket.on("message", new Emitter.Listener() {
    @Override
    public void call(Object... args) {
      System.out.println(args)
    }
})

socket.connect()
