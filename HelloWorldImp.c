#include <jni.h>
#include "HelloWorld.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_HelloWorld_displayHelloWord
(JNIEnv * env, jobject obj){
	printf("Hello World jasdfasdf\n");
	return;
}
