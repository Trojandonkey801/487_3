#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <unistd.h>
void GetLocalTime(time_t * toreturn){
	time_t rawtime;
	time ( &rawtime );
	*toreturn = rawtime;
	printf("asdf %lu",rawtime);
}
int main(int argc, char *argv[])
{
	time_t temp;
	GetLocalTime(&temp);
	return 0;
}
