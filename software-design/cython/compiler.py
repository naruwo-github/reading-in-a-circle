from distutils.core import setup
from Cython.Build import cythonize

setup(ext_modules=cythonize(['summation.pyx']))
setup(ext_modules=cythonize(['summationWithStaticType.pyx']))
