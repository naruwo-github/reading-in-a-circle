from summationWithStaticType import summationWithStaticType
import time

n = 100000000
time_start = time.time()
print(summationWithStaticType(n))
time_end = time.time()
time_diff = time_end - time_start

print("{} seconds passed.".format(time_diff))
