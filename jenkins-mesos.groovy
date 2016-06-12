import jenkins.model.*
import org.jenkinsci.plugins.mesos.*

def instance = Jenkins.getInstance()
def env = System.getenv()
instance.setNumExecutors(0)

def cloudList = instance.clouds

List<MesosSlaveInfo.ContainerInfo> slaveContainers = new ArrayList<MesosSlaveInfo.ContainerInfo>()

def cloud = new MesosCloud(
    nativeLibraryPath = '/usr/lib/libmesos.so',
    master = 'zk://leader.mesos:2181/mesos',
    description = '',
    frameworkName = 'jenkins',
    role = '',
    slavesUser = 'root',
    credentialsId = '',
    principal = 'jenkins',
    secret = '',
    slaveInfos = slaveContainers,
    checkpoint = false,
    onDemandRegistration = true,
    jenkinsURL = env['JENKINS_MESOS_URL'] ?: '',
    declineOfferDuration = ''
)

  cloudList.add(cloud)