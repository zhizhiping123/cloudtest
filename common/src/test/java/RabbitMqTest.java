import com.zzping.common.application.CommonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonApplication.class)
public class RabbitMqTest{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private ConnectionFactory connectionFactory;
    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("test",  "我要发财");
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
              //  System.out.println(correlationData.getId());
                if(ack){
                    System.out.println("确认消息");
                }
            }
        });
    }

    @Test
    public void testTopic(){
      //  rabbitTemplate.setMessageConverter();
        amqpAdmin.declareExchange(new DirectExchange("topic1",true,false));
        rabbitTemplate.convertAndSend("topic1","","错误级别日志");
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
                //  System.out.println(correlationData.getId());
                if(ack){
                    System.out.println("确认消息");
                }
            }
        });
    }
}
