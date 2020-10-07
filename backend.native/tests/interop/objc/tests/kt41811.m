#import "kt41811.h"
#import "assert.h"

id retainObject = nil;

@implementation DeallocRetainRelease
-(void)dealloc {
    retainObject = self;
    assert(retainObject == self);
    retainObject = nil;
}
@end;
