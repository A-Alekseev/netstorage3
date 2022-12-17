package org.example.server;

import com.example.core.model.InnerMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageHandler extends SimpleChannelInboundHandler<InnerMessage> {
    private static Logger log = LoggerFactory.getLogger(Server.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, InnerMessage innerMessage) throws Exception {
        for (String a : innerMessage.getArguments()) {
            log.debug(a);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        InnerMessage m = new InnerMessage();
        m.setArguments(new String[] {"three", "for"});
        ctx.writeAndFlush(m);
    }
}
