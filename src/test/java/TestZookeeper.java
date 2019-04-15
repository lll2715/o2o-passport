import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;
import org.junit.Test;

/**
 * Created by liufeixiang on 2019/3/26.
 */
public class TestZookeeper {

    public static void main(String[] args) {
        // 60000 session超时时间；1000 连接超时时间
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 60000, 10000);
        // 节点（路径）；值；节点类型 PERSISTENT永久节点
        //zkClient.create("/projectx","1", CreateMode.PERSISTENT);
        zkClient.create("/projectx/modulex","a9993e364706816aba3e25717850c26c9cd0d89d", CreateMode.PERSISTENT);
        zkClient.close();
        System.out.println("###注册成功###");
    }

    @Test
    public void test() throws Exception {
        // 创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper("localhost:2181",500000, new Watcher() {
        // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });
        // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath",false,null)));
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath",true));
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
        System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]");
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
//        zk.delete("/testRootPath/testChildPathTwo",-1);
//        zk.delete("/testRootPath/testChildPathOne",-1);
//        // 删除父目录节点
//        zk.delete("/testRootPath",-1);
        // 关闭连接
        zk.close();
    }
}
