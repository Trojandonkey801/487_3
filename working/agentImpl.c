#include "jni.h"
#include "agent.h"
#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
void GetLocalTime(time_t * toreturn);
JNIEXPORT jobject JNICALL Java_agent_C_1getLocalTime
(JNIEnv * env, jobject obj1, jobject obj2){
	jclass cls = (*env)->GetObjectClass(env,obj2);

	jfieldID fidID = (*env)->GetFieldID(env,cls,"ID","I");
	jint iVal = (*env)->GetIntField(env,obj2,fidID);

	jfieldID fidStartUpTime = (*env)->GetFieldID(env,cls,"StartUpTime","I");
	jint siVal = (*env)->GetIntField(env,obj2,fidStartUpTime);

	jfieldID fidcID = (*env)->GetFieldID (env, cls, "CmdAgentID", "Ljava/lang/String;");
	jobject stringVal = (*env)->GetObjectField (env, obj2, fidcID);

	const char *c_str;
	c_str = (*env)->GetStringUTFChars (env, stringVal, NULL);

	time_t toapply;
	GetLocalTime(&toapply);
	int time = (int)toapply;
	jmethodID constructor_method = (*env)->GetMethodID(env,cls,"<init>","(IILjava/lang/String;)V");
	jobject wObj = (*env)->NewObject(env,cls,constructor_method,1,time,(*env)->NewStringUTF(env,c_str));
	printf("%d \n",iVal);
	printf("%d \n",siVal);
	printf ("sVal: %s\n", c_str);
	(*env)->ReleaseStringUTFChars(env, stringVal, c_str);
	return wObj;
}

void GetLocalTime(time_t * toreturn){
	time_t rawtime;
	time ( &rawtime );
	*toreturn = rawtime;
}

