/*********************************************************************
 *
 * Authors: Vincenzo Ciaschini - Vincenzo.Ciaschini@cnaf.infn.it 
 *          Valerio Venturi - Valerio.Venturi@cnaf.infn.it 
 *
 * Copyright (c) 2002, 2003 INFN-CNAF on behalf of the EU DataGrid.
 * For license conditions see LICENSE file or
 * http://www.edg.org/license.html
 *
 * Parts of this code may be based upon or even include verbatim pieces,
 * originally written by other people, in which case the original header
 * follows.
 *
 *********************************************************************/

extern "C" {
#include "config.h"
#include <sys/time.h>
#include <sys/resource.h>
#include <sys/mman.h>
}

#include <string>

#include "vomsclient.h"

int main(int argc, char** argv) {

  struct rlimit newlimit = {0,0};
  if (setrlimit(RLIMIT_CORE, &newlimit) != 0)
    exit(1);

  Client v(argc, argv);
  v.Run();

  return 0;

}
