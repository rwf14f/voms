/*********************************************************************
 *
 * Authors: Vincenzo Ciaschini - Vincenzo.Ciaschini@cnaf.infn.it 
 *
 * Copyright (c) 2002-2009 INFN-CNAF on behalf of the EU DataGrid
 * and EGEE I, II and III
 * For license conditions see LICENSE file or
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Parts of this code may be based upon or even include verbatim pieces,
 * originally written by other people, in which case the original header
 * follows.
 *
 *********************************************************************/
#ifndef VOMS_ERRORS_H
#define VOMS_ERRORS_H

#include <string>

struct errorp {
  int num;
  std::string message;
};

#define ERROR_OFFSET 1000
#define WARN_OFFSET     0

#define WARN_NO_FIRST_SELECT (WARN_OFFSET + 1)
#define WARN_SHORT_VALIDITY  (WARN_OFFSET + 2)
#define WARN_ATTR_SUBSET     (WARN_OFFSET + 3)

#define ERR_WITH_DB         (ERROR_OFFSET + 3)
#define ERR_NOT_MEMBER      (ERROR_OFFSET + 1)
#define ERR_ATTR_EMPTY      (ERROR_OFFSET + 2)
#define ERR_SUSPENDED       (ERROR_OFFSET + 4)

#endif
