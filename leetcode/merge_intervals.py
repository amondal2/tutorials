def merge_intervals(intervals):
    intervals.sort(key=lambda x: x[0])
    merged = []
    for interval in intervals:
        if not merged or merged[-1][1] < interval[0]:
            merged.append(interval)
        else:
            merged[-1][1] = max(merged[-1][1], interval[1])
    return merged


if __name__ == '__main__':
    intervals = [[2,6],[1,3],[8,10],[15,18]]
    merge_intervals(intervals)