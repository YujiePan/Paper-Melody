# opencv����Android Studio����

����һ�����ѵĲ��������ܽ�������·���

0�������ҸĹ����̵�gradle�����ļ�������opencvû�����������������ʻ�gradleʧ��
1������������opencv for android 3.2��Ȼ���ѹ��
2��AS->File->New->Import Module ѡ����(ѹ����·��)/sdk/java�ļ��У�Ȼ����ģ����ļ�����ͳһ����ΪopenCVLibrary320
3���ڵ����openCVLibrary320�ļ���Ŀ¼���޸�build.gradle�ļ��ĸ��ְ汾������Ŀͬ��
4��AS->File->Project Structure-->app->Dependencies����Ӻ����Module Dependency��ѡ��openCVLibrary��ȷ��
5����app/src/mainĿ¼���½��ļ���jniLibs��Ȼ���(ѹ����·��)/sdk/native/libs�ļ���Ŀ¼�������ļ�����app/src/main/jniLibs
6������Gradle����û�б�������ɹ�
7��ʹ��opencv��ʱ����Ҫ��ÿ��java�ļ���ͷ��д  static{ System.loadLibrary("opencv_java3"); } ��䣬�Ӷ����Ա����ֻ����谲װopencvManager������
8���������ϲ���֮�������������Գ���һ������app�������ļ�MainActivity.java������������ť�ܹ������л�����󹦸��

����������ʣ�����ϵ��