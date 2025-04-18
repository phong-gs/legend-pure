// Copyright 2020 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.pure.m4.coreinstance.primitive.date;

import java.util.GregorianCalendar;

public interface PureDate extends Comparable<PureDate>
{
    int getYear();

    boolean hasMonth();

    int getMonth();

    boolean hasDay();

    int getDay();

    boolean hasHour();

    int getHour();

    boolean hasMinute();

    int getMinute();

    boolean hasSecond();

    int getSecond();

    boolean hasSubsecond();

    String getSubsecond();

    PureDate addYears(long years);

    PureDate addMonths(long months);

    PureDate addWeeks(long weeks);

    PureDate addDays(long days);

    PureDate addHours(long hours);

    PureDate addMinutes(long minutes);

    PureDate addSeconds(long seconds);

    PureDate addMilliseconds(long milliseconds);

    PureDate addMicroseconds(long microseconds);

    PureDate addNanoseconds(long nanoseconds);

    PureDate addSubseconds(String subseconds);

    PureDate subtractSubseconds(String subseconds);

    /**
     * Get a Gregorian calendar representation of this Pure date.
     * Note that precision may be lost if the Pure date has
     * precision greater than millisecond.
     *
     * @return Gregorian calendar for Pure date
     */
    GregorianCalendar getCalendar();

    default <T extends Appendable> T appendString(T appendable)
    {
        return DateFormat.append(appendable, this);
    }

    default <T extends Appendable> T appendFormat(T appendable, String formatString)
    {
        return DateFormat.format(appendable, formatString, this);
    }

    default void writeString(Appendable appendable)
    {
        appendString(appendable);
    }

    default String format(String formatString)
    {
        return appendFormat(new StringBuilder(32), formatString).toString();
    }

    default void format(Appendable appendable, String formatString)
    {
        appendFormat(appendable, formatString);
    }

    default long dateDifference(PureDate otherDate, String unit)
    {
        return DateFunctions.dateDifference(this, otherDate, unit);
    }

    @Override
    default int compareTo(PureDate pureDate)
    {
        return DateFunctions.compare(this, pureDate);
    }
}
